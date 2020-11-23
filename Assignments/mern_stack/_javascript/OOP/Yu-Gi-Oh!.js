
class Card {
    constructor(name,cost){
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card{
    constructor(name,cost,power,res){
        super(name,cost);
        this.power = power;
        this.res = res; // resilience
    }

    attack(target){
        // reduce target res by power
        target.res -= this.power;
    }
}

class Effect extends Card{
    constructor(name,cost,text,stat,magnitude){
        super(name,cost);
        this.text = text;
        this.stat = stat;
        this.magnitude = magnitude;
    }

    play( target ) {
        if( target instanceof Unit ) {
            if (this.stat == 'res'){
                target.res += this.magnitude;
            }
            else if (this.stat == 'power') {
                target.power += this.magnitude; 
            }
            console.log(this.text);
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

// const red_belt_ninja = new Unit('Red Belt Ninja',3,3,4)
// const black_belt_ninja = new Unit('Black Belt Ninja',4,5,4)

const hard_algorithm = new Effect('Hard Algorithm',2,`increase target's resilience by 3`,'res',3);
const unhandled_promise_rejection = new Effect('Unhandled Promise Rejection',1,`reduce target's resilience by 2`,'res',-2);
const pair_programming = new Effect('Pair Programming',3,`increase target's power by 2`,'res',2);


let player1 = [];
let player2 = [];


// Tern 1
player1.push(new Unit('Red Belt Ninja',3,3,4));
console.log(player1,player2);
hard_algorithm.play(player1[0]);
console.log(player1,player2);

// Tern 2
player2.push(new Unit('Black Belt Ninja',4,5,4));
console.log(player1,player2);
unhandled_promise_rejection.play(player1[0]);
console.log(player1,player2);

// Tern 3 
pair_programming.play(player1[0]);
console.log(player1,player2);
player1[0].attack(player2[0]);
console.log(player1,player2);
