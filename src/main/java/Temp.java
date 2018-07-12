import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author mummareddy.mahesh
 */
public class Temp {
        public static int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new LinkedHashSet<>();
            int j=0 ,maxSubStr=0;
            int n=s.length();
            while(j<n)
            {
                if(!set.contains(s.charAt(j)))
                {
                    set.add(s.charAt(j));
                    maxSubStr = Math.max(maxSubStr,set.size());
                }
                else
                {
                    set = reSetSetValues(s.charAt(j),set);
                }
                j++;
            }
            return maxSubStr;

        }
        static HashSet<Character> reSetSetValues(char ch,HashSet<Character> set)
        {
            HashSet<Character> tempset = new LinkedHashSet<Character>();
            tempset.addAll(set);
            Iterator<Character> it=set.iterator();
            while(it.hasNext())
            {
                char temp=it.next();
                if(temp!=ch)
                {
                    tempset.remove(temp);
                }
                else
                {
                    tempset.remove(temp);
                    break;
                }

            }
            return tempset;
        }
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
            ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next =new ListNode(9);
        System.out.println(addTwoNumbers(l1,l2));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
            twoSum(new int[]{3,2,4},6);
        System.out.println(lengthOfLongestSubstring("ohome"));
        HashSet<Integer> temp=new HashSet<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        Iterator<Integer> iterator = temp.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
    public static int lengthOfLongestSubstring2(String s) {
        StringBuffer sb = new StringBuffer();
        int maxLength=0;
        String str ="";
        for(int i=0;i<s.length();)
        {

            if(!str.contains(Character.toString(s.charAt(i))))
            {
                str= str+s.charAt(i);
                maxLength= Math.max(maxLength,str.length());
                i++;
            }
            else{
                int ind=str.indexOf(s.charAt(i));
                str =str.substring(ind+1,str.length());
            }
        }
        return maxLength;
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i=0,j=nums.length-1;i<j;)
        {
            int sum = nums[i]+nums[j];
            if(target==sum)
            {
                return new int[]{i,j};
            }
            else if (target>sum)
            {
                i++;
            }
            else if (target<sum)
            {
                j--;
            }
        }
        return new int[]{-1,-1};
    }


      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry =0;
            ListNode list=addTwoNums(l1,l2,carry);
            return list;
        }
        static ListNode addTwoNums(ListNode l1, ListNode l2,int carry)
        {
            ListNode root,prev;
            if (l1 == null && l2!=null)
            {
                int data = l2.val+carry;
                carry = data / 10 ;
                data = data % 10 ;
                root = new ListNode(data);
                root.next = addTwoNums(null,l2.next,carry);
            }
            else if(l2==null && l1!=null)
            {
                int data = l1.val+carry;
                carry = data / 10 ;
                data = data % 10 ;
                root = new ListNode(data);
                root.next = addTwoNums(l1.next,null,carry);
            }
            else if (l1==null && l2==null && carry==0)
            {
                return null;
            }
            else if (l1==null && l2==null && carry!=0)
            {
                return new ListNode(carry);
            }
            else {
                int data = l1.val+l2.val+carry;
                carry = data / 10 ;
                data = data % 10 ;
                root = new ListNode(data);
                root.next = addTwoNums(l1.next,l2.next,carry);
            }
            return root;
        }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int reslength=n1+n2;
        int res[] =new int[reslength];
        int k=0;
        for (int i=0,j=0;k<=reslength/2;k++)
        {
            if(i==n1)
            {
                while(k<=reslength/2)
                {
                    res[k]=nums2[j];
                    j++;
                    k++;
                }
                break;
            }
            else if(j==n2)
            {
                while(k<=reslength/2)
                {
                    res[k]=nums1[i];
                    i++;
                    k++;
                }
                break;
            }
            else if (nums1[i]>=nums2[j])
            {
                res[k]=nums2[j];
                j++;
            }
            else if (nums1[i]<nums2[j])
            {
                res[k]=nums1[i];
                i++;
            }

        }
        if(reslength%2==0)
        {
            return (res[k-1]+ res[k-2])/2.0;
        }
        else
            return res[k-1]*1.0;

    }

}
