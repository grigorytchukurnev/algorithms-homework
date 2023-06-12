package List.impl;

import List.StringList;

import java.util.Arrays;

public class CustomStringList implements StringList {
    private final float GROW_COEFFICIENT = 1.5F;
    private  final int INITIAL_CAPACITY = 10;
    private String[] array = new String[INITIAL_CAPACITY];

    private int size = 0;


    public CustomStringList(){
    }

    @Override
    public String add(String item) {
        if (size == array.length){
            grow();
        }

        array[size] = item;
        ++size;
        return array[size - 1];
    }

    @Override
    public String add(int index, String item) {
        if (size == array.length){
            grow();
        }
        System.arraycopy(
                array,
                index,
                array,
                index + 1,
                size - index
        );
        array[index] = item;
        ++size;
        return array[index];
    }

    @Override
    public String set(int index, String item) {
        array[index] = item;
        return array[index];
    }

    @Override
    public String remove(String item) {
        int removedIndex = indexOf(item);
        if (removedIndex == -1){
            return null;
        }else {
            return remove(removedIndex);
        }
    }

    @Override
    public String remove(int index) {
        if (index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        String removedValue = array[index];
        --size;
        System.arraycopy(
                array,
                index + 1,
                array,
                index,
                size - index
        );
        array[size] = null;
        return removedValue;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size != otherList.size()){
        return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        return array.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(array) ;
    }

    private void grow(){
        int newSize = (int) (size * GROW_COEFFICIENT);
        String[] newArray = new String[newSize];
        System.arraycopy(
                array,
                0,
                newArray,
                0,
                size
        );

        array = newArray;
        size = newSize;
    }
}
