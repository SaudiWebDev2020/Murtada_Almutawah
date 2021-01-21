package com.mamutawah.events.services;

import java.util.List;

import javax.validation.Valid;

import com.mamutawah.events.models.CreateUser;
import com.mamutawah.events.models.Event;
import com.mamutawah.events.models.EventForm;
import com.mamutawah.events.models.Location;
import com.mamutawah.events.models.State;
import com.mamutawah.events.models.User;
import com.mamutawah.events.repositories.EventRepository;
import com.mamutawah.events.repositories.LocationRepository;
import com.mamutawah.events.repositories.StateRepository;
import com.mamutawah.events.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class LoginService {

  private final UserRepository userRepository;
  private final StateRepository stateRepository;
  private final LocationRepository locationRepository;
  private final EventRepository eventRepository;

  public LoginService(UserRepository userRepository, StateRepository stateRepository,
      LocationRepository locationRepository, EventRepository eventRepository) {
    this.userRepository = userRepository;
    this.stateRepository = stateRepository;
    this.locationRepository = locationRepository;
    this.eventRepository = eventRepository;
  }

  public List<State> getAll() {
    return stateRepository.findAll();
  }

  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User registerUser(CreateUser cUser, BindingResult result) {
    if (!cUser.getPassword().equals(cUser.getPasswordConfirmation())) {
      result.rejectValue("passwordConfirmation", "Matches", "The confirmed password is not match Password!");
    }

    User alreadyUser = findByEmail(cUser.getEmail());
    if (alreadyUser != null) {
      result.rejectValue("email", "Existed", "Email is already Existed");
    }

    if (result.hasErrors()) {
      return null;
    } else {
      String hashedPass = BCrypt.hashpw(cUser.getPassword(), BCrypt.gensalt());
      Location location = findORCreate(cUser.getCity(), cUser.getState());
      User u = new User(cUser.getFirstName(), cUser.getLastName(), cUser.getEmail(), location, hashedPass);
      return userRepository.save(u);
    }
  }

  private Location findORCreate(String city, State state) {
    List<Location> lOC = locationRepository.findByState(state);
    if (!lOC.isEmpty()) {
      for (Location location : lOC) {
        if (location.getCity().equals(city)) {
          return location;
        }
      }
    }

    Location newLocation = new Location(city, state);
    return locationRepository.save(newLocation);
  }

  public boolean authenticateUser(String email, String password) {
    User user = userRepository.findByEmail(email);

    if (user == null) {
      return false;
    } else {
      if (BCrypt.checkpw(password, user.getPassword())) {
        return true;
      } else {
        return false;
      }
    }

  }

  public Event createEvent(Long id, @Valid EventForm eventForm) {
    User u = this.getUserById(id);
    if (u == null) {
      System.out.println("Error");
      return null;
    }
    Location l = this.findORCreate(eventForm.getCity(), eventForm.getState());
    Event e = new Event(u, eventForm.getName(), eventForm.getDate(), l);
    return eventRepository.save(e);
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public List<Event> getAllEventInMyState(Long userId) {
    User u = getUserById(userId);
    List<Event> events = eventRepository.findAllFromState(u.getLocation().getState().getId());
    return events;
  }

  public List<Event> getAllEventInOtherState(Long userId) {
    User u = getUserById(userId);
    List<Event> events = eventRepository.findAllFromOtherState(u.getLocation().getState().getId());
    return events;
  }

  public Event getEventByID(Long id) {
    return eventRepository.findById(id).orElse(null);
  }

  public void joinAnEvent(Long event_id, Long user_id) {
    Event e = getEventByID(event_id);
    User u = getUserById(user_id);
    if (e != null) {
      if (!e.getJoining().contains(u)) {
        List<User> newJoining = e.getJoining();
        newJoining.add(u);
        e.setJoining(newJoining);
        eventRepository.save(e);
      }
    }
  }

  public void leaveAnEvent(Long event_id, Long user_id) {
    Event e = getEventByID(event_id);
    User u = getUserById(user_id);
    if (e != null) {
      if (e.getJoining().contains(u)) {
        List<User> newJoining = e.getJoining();
        newJoining.remove(u);
        e.setJoining(newJoining);
        eventRepository.save(e);
      }
    }
  }

  public void removeAnEvent(Long event_id, Long user_id) {
    Event e = getEventByID(event_id);
    User u = getUserById(user_id);
    if (e != null) {
      if (e.getHost().equals(u)) {
        eventRepository.delete(e);
      }
    }
  }

  public Event editEvent(Long userId, Long eventId, @Valid EventForm eventForm) {
    User u = this.getUserById(userId);
    if (u == null) {
      System.out.println("Error");
      return null;
    }
    Event e = getEventByID(eventId);
    e.setName(eventForm.getName());
    e.setDate(eventForm.getDate());
    e.setLocation(this.findORCreate(eventForm.getCity(), eventForm.getState()));
    return eventRepository.save(e);
  }

}
