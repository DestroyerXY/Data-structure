public class HeapSort {
  
    public static void heapSort(int[] arr){
        int n = arr.length;
        
        // Построение кучи (перегруппируем массив)
        for(int i=n/2-1; i>=0; i--)
            heapify(arr, n, i);
        
        // Один за другим извлекаем элементы из кучи
        for(int i=n-1; i>0; i--){
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }
 
    public static void heapify(int[] arr, int n, int i){
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2*i + 1; // Левый потомок узла i
        int right = 2*i + 2; // Правый потомок узла i
 
        // Если левый дочерний элемент больше корня
        if(left < n && arr[left] > arr[largest])
            largest = left;
 
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if(right < n && arr[right] > arr[largest])
            largest = right;
 
        // Если самый большой элемент не является корнем
        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Рекурсивно обновляем позицию наибольшего элемента
            heapify(arr, n, largest);
        }
    }
 
    // Функция для печати массива
    public static void printArray(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[]){
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
 
        heapSort(arr);
 
        System.out.println("Отсортированный массив:");
        printArray(arr);
    }
}