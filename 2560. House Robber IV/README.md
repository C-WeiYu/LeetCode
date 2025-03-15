# 2560. House Robber IV
有一個叫`nums`的 array 代表有 n 間房，`nums[i]`代表每個房子中擁有的金錢。

今天有一個小偷要去幾間房子偷錢，但在遵守以下幾個規則的條件下，請問最小的 capability 為多少？
  1. `nums`:
     
     -  在 nums array 中，`nums[i]`代表每個房子中的金錢數量
     
     -  共有 n 間房 (n = nums.length)
       
  2. `Capability`:
     
     -  capability 代表在小偷所偷的所有房子中，最多錢那間有多少錢
     
     -  假設小偷今天偷了三間房，其中這三間房的金錢為 [2,19,10]，那麼 capability 為 19
      
  3. `k`:
     
     -  在 n 間房中，去偷竊的房子必須至少有 k 間 (去偷竊的房子數量 >= k)
       
  4. 不能偷連續的房子:

     -  假設有 1,2,3,4,5 間房，如果今天先偷了1號房，2號房就不能偷，必須要跳過，選3或4或5繼續
       
> 題目說白話，其實`Capability`就是在所有偷竊的房子中取**最大值**，並且在所有符合 數量 >= k 的例子中，取所有 capability 的**最小值**
>
> **即取 maximum 的 minimum**

## 解題思路
### 方法1. Brute Froce
一開始看到題目可能直覺會想把所有大於等於 k 的組合都找出來，

以 max 去取每組的 capability，再透過 min 找出最小的 capability，

這樣的方法雖然可行，但運行時間過久。

### 方法2. Binary Search

換個方向想，其實 capability 就代表著小偷選擇房子的門檻，

如果今天在 capability == 10 的情況下，可以偷 5 間房，而 k 為 3，

這代表在我們目前的選擇中，這組符合規則的選擇中，capability 為 10，

就不用先將選擇中的所有房子金額列出來，去取最大值，最後再取最小值。

**因此我們可以將題目變成，在符合數量>=k的情況下，取 capability 的最小值。**

先以房子中最少錢的金額設為 min，並將最多錢的金額設為 max，

以 **Binary Search** 從 min 與 max 中找中間值 (mid)，可能會有以下兩種情形:
1. 金額大於 mid 的房子數量 >= k
   
   -  代表目前 capability 太大，因此降低 capability (詳情見[重點1](#point1))

   -  將 max 設為 mid

2. 金額大於 mid 的房子數量 < k

   -  代表目前這個 capability 太小，因此增加 capability，

   -  將 min 設為 left + 1

反覆持續上述，直到 min == max

## 重點
<a id="point1"></a>
1. 為什麼當可偷竊的房子數量 >=K 時，是要降低 capability?

    * 因為題目最終目的是要求所有 capability 的 miniumum，數量 >= k 代表還有機會可以更低
2. **當題目要在一群 最大值中取最小值 or 最小值中取最大值 時，通常會是 binary search 題型**
