# 3488. Closest Equal Element Queries
有一個**可循環**的 array 叫`nums`，與一個存放要查詢的index的 array 叫 `queries`
1. `nums`:
  
    - 左右循環，當 nums[0] 往左走時，會變 nums[nums.length - 1]

    - 用來儲存要被查詢的數字，可能會重複

2. `queries`:

    - 儲存要查詢的 nums 的 index，nums[j] = nums[queries[i]]
 
    - 例如: queries[0] = 3，即指 nums[3]

求 queries 中，與 nums[qeuries[i]] 值相同的所有數中，最短距離為多少？

如果沒有其他相同的值，則回傳 -1。
    
      EX:
    
      Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]
      Output: [2,-1,3]
      
      Explanation:
      Query 0: The element at queries[0] = 0 is nums[0] = 1. 
      The nearest index with the same value is 2, and the distance between them is 2.
      
      Query 1: The element at queries[1] = 3 is nums[3] = 4. 
      No other index contains 4, so the result is -1.
      
      Query 2: The element at queries[2] = 5 is nums[5] = 3. 
      The nearest index with the same value is 1, and the distance between them is 3 
      (following the circular path: 5 -> 6 -> 0 -> 1).

## 解題思路
先將 nums 中，相同數字的 index 以 map<Integer, List<Integer>> 儲存，

算出 nums 中每個 index 與 nums[index] 值相同的最短距離，

最後只要依序將 queries 中對照的 nums[queries[i]] 值回傳即可。

## 重點
1. **循環的題目要善用 %**
    - 例如: index1 = 0 , index2 = 1, index3 = 2 , nums.length = 3, 我要怎麼知道 index1 的前一個會跑到 index3？

    - 只要透過 ((index1 - 1) + nums.length) % nums.length 即可
  
    - 反之，((index3 + 1) + nums.length) % nums.length 也會得到 index1 

2. map 的 value 中，list 的長度可能為 1 或 > 1，代表什麼？

    - 當 list.size() == 1，代表 nums 中，key 的值只出現一次，因此回傳 -1 即可

    - **當 list.size() > 1，僅需要注意 list.get(i)-1 與 list.get(i)+1**
  
      - 如果當初放入 map 中，是從 nums[0] 開始依序放入，list 中的順序，前後及代表距離最短的前一個和下一個
        
3. 因為可以循環，計算兩點 (a,b) 最短距離時應考慮順時針與逆時針

    - distance1 = Math.abs(a - b) 與 nums.legnth - distance 兩者取 min
