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
        // console.log("swap", this.heap[i], "with", this.heap[currentIndex]);
        [this.heap[i], this.heap[currentIndex]] = [this.heap[currentIndex], this.heap[i]];
        currentIndex = i;
      }
    }
  }

  remove() {
    let value = this.heap[1];
    // your code here

    // check if the heep is not empty
    if (this.heap.length == 1) {
      return;
    }

    // swap the first and the element.
    [this.heap[1], this.heap[this.heap.length - 1]] = [this.heap[this.heap.length - 1], this.heap[1]];

    // remove the last element
    this.heap.pop();

    // normalize by looping from the begging to the end.
    for (let currentIndex = 1; currentIndex < this.heap.length; currentIndex = currentIndex * 2) {
      let leftChildIndex = 2 * currentIndex;
      let rightChildIndex = 2 * currentIndex + 1;
      if (this.heap[currentIndex] > this.heap[rightChildIndex] || this.heap[currentIndex] > this.heap[leftChildIndex]) {
        if (this.heap[rightChildIndex] < this.heap[leftChildIndex]) {
          [this.heap[currentIndex], this.heap[rightChildIndex]] = [this.heap[rightChildIndex], this.heap[currentIndex]];
        } else {
          [this.heap[currentIndex], this.heap[leftChildIndex]] = [this.heap[leftChildIndex], this.heap[currentIndex]];
        }
      }
    }

    return value;
  }
}

const heap1 = new MinHeap();
heap1.insert(3);
// the heap should look like [null, 3]
heap1.insert(5);
// the heap should look like [null, 3, 5]
heap1.insert(1);
// the heap should look like [null, 1, 5, 3]
heap1.insert(1);
heap1.insert(10);
heap1.insert(1);
heap1.insert(3);
console.log(heap1.heap);
console.log(heap1.remove());

console.log(heap1.heap);

console.log(heap1.remove());
// console.log(heap1.remove());
// console.log(heap1.remove());
// console.log(heap1.remove());
// console.log(heap1.remove());
// console.log(heap1.remove());
// console.log(heap1.remove());
console.log(heap1.heap);
