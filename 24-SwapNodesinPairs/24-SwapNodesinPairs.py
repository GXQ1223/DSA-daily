class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        # Check if the list is empty or has only one node
        if not head or not head.next:
            return head
        
        # Initialize odd and even nodes
        odd = head
        even = head.next
        oddPtr = odd
        evenPtr = even
        
        # Swap the nodes pair by pair
        while oddPtr and evenPtr:
            # Link odd node to the next odd node
            oddPtr.next = evenPtr.next
            oddPtr = oddPtr.next
            
            # If there are no more odd nodes, break the loop
            if not oddPtr:
                break
            
            # Link even node to the next even node
            evenPtr.next = oddPtr.next
            evenPtr = evenPtr.next

        # Reconnect the odd and even nodes correctly
        self.stitch(even, odd)

        # Return the new head (even node)
        return even

    def stitch(self, even: ListNode, odd: ListNode):
        ePtr = even
        oPtr = odd
        
        # Stitch the odd and even nodes together
        while ePtr and oPtr:
            e = ePtr.next
            o = oPtr.next
            ePtr.next = oPtr  # Connect the even node to the odd node
            
            # If the even node has no more elements, stop
            if not e:
                break
                
            oPtr.next = e  # Connect the odd node to the even node
            ePtr = e  # Move the pointer for even nodes
            oPtr = o  # Move the pointer for odd nodes
