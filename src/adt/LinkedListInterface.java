/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Ooi Chin Hui
 */
public interface LinkedListInterface<T> {

    //Remove all value in the linked list
    public void clear();

    //Print List
    public void printLinkedList();

    //Directly add value, regardless position
    public boolean add(T newEntry);

    //Add value, position matter
    public boolean add(int position, T newEntry);

    //Remove node based on the position given
    public boolean remove(int position);

    //Replace the node with new value
    public boolean replace(int position, T newEntry);

    //Get the entry from node based on position given
    public T getEntry(int position);

    //Check if the linked list contain the given value
    public boolean contain(T entry);

    //Sort the linked list in ascending order
    public void sortLinkedListAscending();

    //Sort the linked list in descending order
    public void sortLinkedListDescending();

    //Get the number of entries stored inside the linked list
    public int getNumberOfEntries();

    //Check if the linked list is empty
    public boolean isEmpty();

    //Return all the value stored inside the linked list
    public String toString();
}
