class Ninja{
    constructor(name){
        this.name = name;
        this.health = 0;  // No default value so I set it to 0.
        this.speed = 3;
        this.strength = 3;
    }

    sayName(){
        console.log(`Ninja name is ${this.name}`);
    }

    showStats(){
        console.log(`Showing Ninja stats:
health:     ${this.health}
speed:      ${this.speed}
strength:   ${this.strength}`)
    }

    drinkSake(){
        this.health += 10;
    }
}


const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();
ninja1.showStats();