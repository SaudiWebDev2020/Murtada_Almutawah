function hash(key) {
  var res = 0;
  for (var i = 0; i < key.length; i++) {
    res += key.charCodeAt(i);
    res *= 7; // add in some random-noise
  }
  return res;
}
class HashMap {
  constructor(capacity = 100) {
    this.capacity = capacity;
    this.map = new Array(capacity); // Edit it to init 100 empty slots
  }

  put(key, value) {
    // add the key value pair to the map!
    let hass = hash(key);
    let index = hass % this.capacity;
    // console.log(index, this.map, this.map.length);

    if (!this.map[index]) {
      this.map[index] = [];
    }
    this.map[index].push({ key, value });
  }

  get(key) {
    // return the value stored at `key`
    let hashIndex = hash(key);
    let index = hashIndex % this.capacity;
    if (this.map[index]) {
      for (let i = 0; i < this.map[index].length; i++) {
        if (this.map[index][i].key === key) {
          return this.map[index][i];
        }
        // console.log(this.map[index][i]);
      }
    }
    return "Not Found";
  }
}

hass = new HashMap();
hass.put("1234", { name: "Murtada", score: 1 });
hass.put("1221", { name: "Murtada", score: 1 });
// hass.put("Murtada", 2);
// console.log(hass.map);
// console.log(hass.map);
console.log(hass.get("1234"));
