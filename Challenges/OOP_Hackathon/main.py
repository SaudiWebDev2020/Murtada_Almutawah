from datetime import date, datetime
# Statement: Creating booking system where a customer can book from the theatre a specific room to watch a movie with other people.
# (Visualizing the current system of booking a movie)


class Theatre:
    def __init__(self, name):
        print('Theatre')
        self.name = name
        self.rooms = []
        self.movies = []

    def addMovie(self, movie):
        self.movies.append(movie)
        return self

    def addRoom(self, room):
        self.rooms.append(room)
        return self

    def displayAvailableMovies(self):
        for room in self.rooms:
            for period in room.periods:
                print(
                    f"Room: {room.room_number}, Period: {period['period_number']}, {period['movie']}")

    def displayMovies(self):
        for item in self.movies:
            print(item)
        return self

    def displayRooms(self):
        for item in self.rooms:
            print(item)
        return self

    def make_booking(self, user, room_number, period_number):
        for room in self.rooms:
            # print(room)
            if room.room_number == room_number:
                room.make_booking(user, period_number)
        return self

    def __str__(self):
        return f'Welcome To {self.name} theatre'


class Room:
    room_counter = 0

    def __init__(self, num_of_chairs):
        Room.room_counter += 1
        self.room_number = Room.room_counter
        self.num_of_chairs = num_of_chairs
        self.periods = []

    def __repr__(self):
        return(self.room_number)

    def __str__(self):
        return f'Room number: {self.room_number}, Number of chairs:{self.num_of_chairs}'

    def createPeriod(self, date, starting_time, ending_time, price, movie):
        # periods = [
        #   {Date: 12/10/2020, Periods: {"starting_time": 10am, 'ending_time': 12pm, price_per_one: 100, Movie: "Jhon wick", "Joiners": ['Sultan', 'Murtada']}}
        # ]
        period = {
            "period_number": len(self.periods)+1,
            "date": date,
            "starting_time": starting_time,
            "ending_time": ending_time,
            "movie": movie,
            "price": price,
            "viewers": []
        }
        self.periods.append(period)

    def displayPeriod(self, period_number):
        for period in self.periods:
            if period['period_number'] == period_number:
                print(period)

    def displayPeriods(self):
        for period in self.periods:
            print(
                f'Period Number: {period["period_number"]}, Date:{str(period["date"])}, Starting Time:{period["starting_time"].strftime("%H:%M")}, Ending Time:{period["ending_time"].strftime("%H:%M")}, Movie: {period["movie"].title}, Price: ${period["price"]}')

    def make_booking(self, user, period_number):
        for period in self.periods:
            # print(period)
            if period['period_number'] == period_number and len(period['viewers']) <= self.num_of_chairs:
                period['viewers'].append(user)
                # print(period)

        # print(user, period_number)


class Movie:
    def __init__(self, title, releaseyear, length, rating, genre):
        self.title = title
        self.releaseyear = releaseyear
        #self.description = description
        self.length = length
        self.rating = rating
        self.genre = genre

    def __str__(self):
        return f"Title:{self.title}, Release Year: {self.releaseyear}, Length: {self.length} min, Rating: {self.rating}, Genre: {self.genre}"

    def __repr__(self):
        return f'{self.title}'


class User:
    def __init__(self, name, age, phone):
        self.name = name
        self.age = age
        self.phone = phone

    def __repr__(self):
        return(f'{self.name}')

    def __str__(self):
        return f"Name: {self.name}, Age: {self.age}, Phone: {self.phone}"


# Main magic
if __name__ == "__main__":

    # name = input("Enter your name:")
    # print("Hello", name)

    # Init Theatre
    fox = Theatre('Fox')

    # Creating Movies
    johnWick = Movie(title='John Wick', releaseyear=2014,
                     length=120, rating="G", genre="Action")

    skyscraper = Movie(title='Skyscraper', releaseyear=2018,
                       length=143, rating="G", genre="Action & Adventure")

    theConjuring = Movie(title='The Conjuring', releaseyear=2013,
                         length=110, rating="G", genre="Horror")

    # Adding movies to the theater

    fox.addMovie(johnWick).addMovie(
        skyscraper).addMovie(theConjuring)  # .displayMovies()

    # Creating & Adding rooms to the theater
    fox.addRoom(Room(12)).addRoom(Room(24))  # .displayRooms()

    # Create 3 Users
    murtada = User('Murtada', 25, '051234578')
    phil = User('phil', 35, '0553452980')
    sultan = User('sultan', 23, '0555777555')

    '''
    print(murtada)
    print(sultan)
    print(phil, '\n', sultan)
    '''

    # Create a period for the movie
    fox.rooms[0].createPeriod(date=date(2020, 12, 1),
                              starting_time=datetime(2020, 12, 1, 22), ending_time=datetime(2020, 12, 2, 00), price=20, movie=fox.movies[0])

    fox.rooms[0].createPeriod(date=date(2020, 12, 1),
                              starting_time=datetime(2020, 12, 1, 22), ending_time=datetime(2020, 12, 2, 00), price=10, movie=fox.movies[1])

    # Desplay periods for room 0
    fox.rooms[0].displayPeriods()

    # Making Booking to watch a movie in specific room & specific period
    fox.make_booking(sultan, room_number=1, period_number=2)
    fox.make_booking(murtada, room_number=1, period_number=2)
    fox.make_booking(phil, room_number=1, period_number=2)

    print('-'*90)
    fox.rooms[0].displayPeriod(2)
    print('-'*90)
    # Show me all movies
    fox.displayAvailableMovies()


# Thanks alot Murtada .. okay thanks .. hahahaha
# Thank you too :)). I will send you the code to try it. if you have any qustion please do not hasitate =).  LOL.
