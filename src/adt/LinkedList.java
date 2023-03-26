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
public class LinkedList<T extends Comparable<T>> implements LinkedListInterface<T> {

    private Node firstNode;             // reference to first node
    private Node lastNode;              // reference to last node
    private int numberOfEntries;  	// number of entries in list

    public LinkedList() {
        clear();
    }

    @Override
    //Clear the linked list
    public final void clear() {
        //Assign first null to be null
        firstNode = null;
        //Assign last node to be null
        lastNode = null;
        //Assign number of entry into 0
        numberOfEntries = 0;
    }

    @Override
    public void printLinkedList() {
        //Create a temporary node for indication which node is accessing currently
        Node tempNode = firstNode;
        //While not the end of node
        while (tempNode != null) {
            //Print out the data
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    @Override
    //Directly add, position not given, use the last Node (Settle)
    public boolean add(T newEntry) {
        //Create a new empty node for future use
        Node newNode = new Node(newEntry);
        //3 Scenario
        //Scenario 1, the linked list is empty
        //If isEmpty called and is true
        if (isEmpty()) {
            //Directly assign the newly created node to first node and last node (it is node that filled with newEntry information)
            firstNode = newNode;
            lastNode = newNode;
        } //Else the linked list is not empty, thus more work need to be done
        else {
            //If first = last (only 1 entry)
            if (firstNode == lastNode) {
                firstNode.next = newNode;
            }
            //Set the next node of lastNode as newNode
            lastNode.next = newNode;
            //reassign lastNode
            lastNode = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    //Add data to the position given
    public boolean add(int position, T newEntry) {
        //Check if the position given is within the range and valid (larger than 0)
        if ((position >= 1) && (position <= numberOfEntries + 1)) {
            //Create a newNode store the new value
            Node newNode = new Node(newEntry);
            //If the linked list itself is empty, or is meant to add at the beginning
            if (isEmpty() || (position == 1)) {
                firstNode = newNode;
                lastNode = newNode;
            } //Else tranverse from first node until reach the targetted node then assign
            else {
                //Create a node to indicate tranverse
                Node currentNode = firstNode;
                //Loop & tranverse
                //Start from 1 since not using array, not necessarily to start from 0, secondly keep on moving until reach "position"
                for (int i = 1; i <= position; i++) {
                    //move forward to next node
                    currentNode = currentNode.next;
                }
                //Reach the targetted locatiion, assign the current location's next node to newNode and newNode's location to currentNode
                //currentNode's next node location assign to newNode
                newNode.next = currentNode.next;
                //newNode become current node's nextNode
                currentNode.next = newNode;
            }
            //Position doesn't matter just increasing the size indicator by 1
            numberOfEntries++;
        } else {
            //Else the location given is out of bound or invalid, thus return false
            return false;
        }
        //All code executed successfully return true
        return true;
    }

    @Override
    //Remove the data on the position given
    public boolean remove(int position) {
        //Check if the position given is within the range and valid (larger than 0)
        if ((position) >= 1 && (position <= numberOfEntries)) {
            //Check if the position is firstNode
            if (position == 1) {
                //Reasign first node with the next node
                firstNode = firstNode.next;
            } //Else not firstNode, thus loop until reach target location
            else {
                //Create a temporary node for indication which node is accessing currently
                Node previousNode = firstNode;
                //Loop until reach the targetted location
                for (int i = 1; i < position - 1; i++) {
                    //Move forward to next node by reassigning the node accessing with it next location
                    previousNode = previousNode.next;
                }
                //Reach one node before the target location and reassign the node it pointing to the node after the one that we want to remove
                previousNode.next = previousNode.next.next;
                //If the node we want to remove is the last node then we need to reassign lastNode with prviousNode
                if (position == numberOfEntries) {
                    //Reassign lastNode with previousNode
                    lastNode = previousNode;
                }
            }
            //One node is removed thus number of entry is reduced by 1
            numberOfEntries--;
        } //Else the position given is not within the range (out of bound) or invalid (smaller than 0)
        else {
            //False is being returned
            return false;
        }
        //True is being returned
        return true;
    }

    @Override
    //Replace the data of the selected position with the value given
    public boolean replace(int position, T newEntry) {
        //Check if the position given is within the range and valid (larger than 0)
        if ((position) >= 1 && (position <= numberOfEntries)) {
            //Create a temporary node for indication which node is accessing currently
            Node targetNode = firstNode;
            //Loop until reach the targetted position
            for (int i = 0; i < position - 1; i++) {
                //Move forward to next node by reassigning the node accessing with it next location
                targetNode = targetNode.next;
            }
            //Targetted node has reach, we replace the targetted node's data with the newEntry
            targetNode.data = newEntry;
        } //Else the position given is not within the range (out of bound) or invalid (smaller than 0)
        else {
            //False is being returned
            return false;
        }
        //True is being returned
        return true;
    }

    @Override
    //Retrieve data from the given position
    public T getEntry(int position) {
        //Create a temporary variable to store value later on
        T targetData = null;
        //Check if the position given is within the range and valid (larger than 0)
        if ((position >= 1) && (position <= numberOfEntries)) {
            //Create a temporary node for indication which node is accessing currently
            Node targetNode = firstNode;
            //Loop until reach the targetted position
            for (int i = 0; i < position - 1; i++) {
                //Move forward to next node by reassigning the node accessing with it next location
                targetNode = targetNode.next;
            }
            //Targetted node has reach, we retrieve the targetted data into the temporary variable we created earlier
            targetData = targetNode.data;
        }
        //Return the value we get or return null value if the position given is invalid
        return targetData;
    }

    @Override
    //Check if the linked list contain certain data
    public boolean contain(T entry) {
        //Boolean created to act as a flag indicate whether the data is found within the linked list
        boolean found = false;
        //Create a temporary node for indication which node is accessing currently
        Node currentNode = firstNode;
        //While loop which stop when the the data is found or we reach the end of the linked list
        while (!found && (currentNode != null)) {
            //If the data of the current node equals to the
            if (entry.equals(currentNode.data)) {
                //Assign the flag to be true to indicate the data has been found
                found = true;
            } //Else the data is not found in the current node
            else {
                //Proceed to next node and check again
                currentNode = currentNode.next;
            }
        }
        //Return the true or false based on whether the value is found or not
        return found;
    }

    @Override
    //Sort the linked list by ascending order
    public void sortLinkedListAscending() {
        if (numberOfEntries > 1) {
            boolean wasChanged;

            do {
                Node current = firstNode;
                Node previous = null;
                Node next = firstNode.next;
                wasChanged = false;

                while (next != null) {
                    if (current.data.compareTo(next.data) > 0) {
                        /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.next;
                            previous.next = next;
                            next.next = current;
                            current.next = sig;
                        } else {
                            Node sig = next.next;
                            firstNode = next;
                            next.next = current;
                            current.next = sig;
                        }
                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        lastNode = next;
                        next = next.next;
                    }
                }
            } while (wasChanged);
        }
    }

    @Override
    //Sort the linked list by descending order
    public void sortLinkedListDescending() {
        if (numberOfEntries > 1) {
            boolean wasChanged;

            do {
                Node current = firstNode;
                Node previous = null;
                Node next = firstNode.next;
                wasChanged = false;

                while (next != null) {
                    if (current.data.compareTo(next.data) < 0) {
                        /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.next;
                            previous.next = next;
                            next.next = current;
                            current.next = sig;
                        } else {
                            Node sig = next.next;
                            firstNode = next;
                            next.next = current;
                            current.next = sig;
                        }
                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        lastNode = next;
                        next = next.next;
                    }
                }
            } while (wasChanged);
        }
    }

    @Override
    //Get the number of entries in the linked list
    public int getNumberOfEntries() {
        //Return the number of entries in the linked list
        return numberOfEntries;
    }

    @Override
    //Check whether the linked list is empty
    public boolean isEmpty() {
        //If the number of entries = the linked list does not have any entry = the linked list is empty
        if (numberOfEntries == 0) {
            //Return true since the linked list is empty
            return true;
        }
        //Return false because the linked list is not empty
        return false;
    }

    @Override
    //Return all value inside the list in string
    public String toString() {
        String outputStr = "";
        int count = 0;
        Node currentNode = firstNode;
        while (currentNode != null) {
            count++;
            outputStr += String.format("%2d", count) + "\t";
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    //Dont want import, create own node
    private class Node {

        //Use to store generic data
        private T data;
        //Use to indicate the next node
        private Node next;

        //Assign current node data
        private Node(T data) {
            //Assign data into data
            this.data = data;
            //Assign null since not given
            this.next = null;
        }

        //Assign current node data and the location of next node
        private Node(T data, Node next) {
            //Assign current node data
            this.data = data;
            //Assign next node location
            this.next = next;
        }
    }
}
