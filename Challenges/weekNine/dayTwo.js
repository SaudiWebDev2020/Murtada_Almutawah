class MinHeap {
  constructor() {
    this.heap = [null];
  }

  insert(value) {
    let currentIndex = this.heap.length;
    this.heap.push(value);

    // your code here
    for (let i = currentIndex; 0 < i; i = Math.floor(i / 2)) {
      if (this.heap[i] > this.heap[currentIndex]) {
        console.log("swap", this.heap[i], "with", this.heap[currentIndex]);
        [this.heap[i], this.heap[currentIndex]] = [
          this.heap[currentIndex],
          this.heap[i],
        ];
        currentIndex = i;
      }
    }
  }
}

const heap1 = new MinHeap();
heap1.insert(3);
// the heap should look like [null, 3]
console.log(heap1);

heap1.insert(5);
// the heap should look like [null, 3, 5]
console.log(heap1);

heap1.insert(1);
// the heap should look like [null, 1, 5, 3]
console.log(heap1);

heap1.insert(1);
console.log(heap1);

heap1.insert(10);
console.log(heap1);

heap1.insert(-1);
console.log(heap1);

heap1.insert(-3);
console.log(heap1);
