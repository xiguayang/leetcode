### String questions

#### 125. Valid Palindrome
after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
- **2 pointers: left and right**
- while(l<r)
- using ```Character.isLetterOrDigit(s.charAt(i))``` to skip non-alphanumeric chars
- compare the chars l and r points to: 
```if(l<r && Character.toLowerCase(s.charAt(l++))!= Character.toLowerCase(s.charAt(r--)))```

#### 680. Valid Palindrome II
Given a string s, return true if the s can be palindrome after deleting at most one character from it.
- **two pointers**
- define a helper method: **Recursion** ```isPalindromeHelper(String s, int l, int r )```
- remove 1 char means: move l or r by 1 will be valid palindrome:
    ```isPalindromeHelper(s, l+1, r )|| isPalindromeHelper(s, l, r-1 )```
#### 9. Palindrome Number
- res = res*10+x%10; x=x/10; 
#### 234. Palindrome Linked List
- **Fast/slow pointer to get mid of linked list**:      
```java      
            Node fast = head;
            Node slow = head;
            //middle: the mid of odd length: ...slow...
            //        the first one of right part for even length: ...slow..
            while( fast!=null&& fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
```
- **Reverse the LinkedList**: slow is the first node of the right half
- compare 2 sub linked lists


#### 3.Longest Substring Without Repeating Characters 
Given a string s, find the length of the longest substring without repeating characters.
- **Sliding window**:
    - left: 
    - right: start from 0, move to s.length()-1
- HashMap<Integer, Integer>: records the latest index position of each char
    - if s.charAt(right) in HM, only when left is at the left or at the position of the index from HM, shrink the window by left+1;
    - update or add the index of the char right pointer points to. 
- record the max length each move: maxLen = Math.max(maxLen, right-left+1);

#### 424. Longest Repeating Character Replacement
Can repalce K times of chars; Return the length of the longest substring containing the same letter you can get after performing the above operations.
- **using an array** to represent frequency of each char
        index            : 0 1 2 ......25
        represent char:    A,B,C.......Z
        frequency[s.charAt(r)-'A'] is the frequency of the char at r inside this substring[l,r]
- **Sliding window** [l,r]
    - move r by 1: r< s.length(), update the frequency of charAt(r) in the frequency array
    - maxfrequency records the max frequency of a char inside the substring:
        ``` Math.max(maxfrequency, frequency[s.charAt(r)-'A'])```
    - if the count of chars need to be replaced to keep repeating chars >k:
        - reduce the frequency of char l points to 
        - shrink subwindow [l+1, r]

#### 76.  Minimum Window Substring
- **HashMap** to record the chars in t, key is char, value is frequency of char
- **Sliding window** to traverse s
    - using count to check if all chars in t already in s: count==t.length()
    - check if the value of char in hashmap >=0 for duplicates of chars in s when updating count
    - shrink window by moving l: check if in hm, updating value by -1 and also the value of char >0 to update the count
- must have a **boolean** to record if find one satisfied substring