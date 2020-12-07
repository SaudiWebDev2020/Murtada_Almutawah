# Using MongoDB

1. Create a database called 'my_first_db'

   ```mongodb
   use my_first_db
   ```

2. Create students collection.

   ```mongodb
   db.createCollection('students')
   ```

3. Each document you insert into this collection should have the following format: ({name: STRING, home_state: STRING, lucky_number: NUMBER, birthday: {month: NUMBER, day: NUMBER, year: NUMBER}})

4. Create 5 students with the appropriate info.

   ```mongodb
   db.students.insert({
       name: 'Murtada',
       home_state: 'California',
       lucky_number: 3,
       birthday: {month: 2, day: 18, year: 1995}
   })

   db.students.insert({
       name: 'Salem',
       home_state: 'California',
       lucky_number: 5,
       birthday: {month: 12, day: 18, year: 1997}
   })

   db.students.insert({
       name: 'John',
       home_state: 'Washington',
       lucky_number: 7,
       birthday: {month: 1, day: 1, year: 1997}
   })

   db.students.insert({
       name: 'Christen',
       home_state: 'Washington',
       lucky_number: 7,
       birthday: {month: 7, day: 25, year: 1993}
   })

   db.students.insert({
       name: 'Sara',
       home_state: 'Washington',
       lucky_number: 13,
       birthday: {month: 3, day: 13, year: 1999}
   })
   ```

5. Get all students.

   ```mongo
   db.students.find().pretty();
   ```

6. Retrieve all students who are from California (San Jose Dojo) or Washington (Seattle Dojo).

   ```mongodb
   db.students.find({$or: [{ home_state: 'Washington'},{ home_state: 'California'}]});
   ```

7. Get all students whose lucky number is greater than 3

   ```mongodb
   db.students.find({lucky_number: {$gt: 3}})
   ```

8. Get all students whose lucky number is less than or equal to 10

   ```mongodb
   db.students.find({lucky_number: {$lt: 10}})
   ```

9. Get all students whose lucky number is between 1 and 9 (inclusive)

   ```mongodb
   db.students.find({$and: [{lucky_number: {$gt: 1}}, {lucky_number: {$lt: 9}}]})
   ```

10. Add a field to each student collection called 'interests' that is an ARRAY. It should contain the following entries: 'coding', 'brunch', 'MongoDB'. Do this in ONE operation.

    ```mongodb
    db.students.update({}, {$set: {interests: ['coding', 'brunch', 'MongoDB']}},{multi: true})
    ```

11. Add some unique interests for each particular student into each of their interest arrays.

    ```mongo
    db.students.update({"_id" : ObjectId("5fce2c20b6a1a470d151fc55")}, {$push: {interests: 'snowboarding'}})
    ```

12. Add the interest 'taxes' into someone's interest array.

    ```mongo
    db.students.update({"_id" : ObjectId("5fce2aeab6a1a470d151fc51")}, {$push: {interests: 'taxes'}})
    ```

13. Remove the 'taxes' interest you just added.

    ```mongo
    db.students.update({"_id" : ObjectId("5fce2aeab6a1a470d151fc51")}, {$pull: {interests: 'taxes'}})
    ```

14. Remove all students who are from California.

    ```mongo
    db.students.deleteMany({"home_state" : "California"});
    ```

15. Remove a student by name.

    ```mongo
    db.students.deleteOne({"name" : "John"});
    ```

16. Remove a student whose lucky number is greater than 5 (JUST ONE)

    ```mongo
    db.students.deleteOne({"lucky_number" : {$gt: 5}});
    ```

17. Add a field to each student collection called 'number_of_belts' and set it to 0.

    ```mongo
    db.students.update({}, {$set: {number_of_belts: 0}},{multi: true})
    ```

18. Increment this field by 1 for all students in Washington (Seattle Dojo).

    ```mongo
    db.students.update({"home_state": "Washington"}, {$inc: {number_of_belts: 1}},{multi: true})
    ```

19. Rename the 'number_of_belts' field to 'belts_earned'

    ```mongo
    db.students.update({}, {$rename: {number_of_belts: 'belts_earned'}},{multi: true})
    ```

20. Remove the 'lucky_number' field.

    ```mongo
    db.students.update({}, {$unset: {lucky_number: 0}},{multi: true})
    ```

21. Add a 'updated_on' field, and set the value as the current date.

    ```mongo
    db.students.update({}, {$set: {updated_on: new Date()}},{multi: true})
    ```
