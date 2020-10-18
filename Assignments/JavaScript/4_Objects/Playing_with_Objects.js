var users = [
    {
        name: "Michael",
        age: 37
    },
    {
        name: "John",
        age: 30
    },
    {
        name: "David",
        age: 27
    }
];


// How would you print/log John's age?
for (var user in users) {
    if (users[user].name == 'John') {
        console.log(users[user].name, "age is", users[user].age);
    }
}

// How would you print/log the name of the first object?
console.log('The name of the first object is', users[0].name);

// How would you print/log the name and age of each user using a for loop?
for (var user in users) {
    console.log(users[user].name, "-", users[user].age);
}