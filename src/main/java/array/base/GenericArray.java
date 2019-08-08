package array.base;

/**
 * @Author: zhangbo
 * @Date: 2019/8/7
 * @Description:
 * @Modified By:
 **/
public class GenericArray<T> {
    private T[] data;
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造方法，默认数组容量为10
    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return 0 == size;
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
        checkIndex(index);
        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
    }

    // 向数组尾插入元素
    public void addLast(T e) {
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndexForRemove(index);
        T t = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;
        return t;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);

    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int i = find(e);
        if (-1 != i) {
            remove(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d capacity = %d", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail request index > 0 and index <= size");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove fail request index > 0 and index < size");
        }
    }

    public static void main(String[] args) {
        GenericArray genericArray = new GenericArray<Integer>(100);
        for (int i = 0; i < 100; i++) {
            genericArray.add(i, i);
        }
        genericArray.remove(10);
        genericArray.set(0,998);
        System.out.println(genericArray.get(0));

        System.out.println(genericArray);
    }
}
