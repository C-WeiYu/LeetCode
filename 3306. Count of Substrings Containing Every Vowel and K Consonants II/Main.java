class Solution {
    public long countOfSubstrings(String word, int k) {
        int[] frequencies = new int[28];

        Set<Integer> set = new HashSet<>();
        set.add('a' - 'a');
        set.add('e' - 'a');
        set.add('i' - 'a');
        set.add('o' - 'a');
        set.add('u' - 'a');

        long res = 0 ;
        int l = 0 ;
        int r = 0 ;
        int vowels = 0 ;
        int consonants = 0 ;
        int extraLeft = 0 ;

        while(r < word.length()){
            char rightChar = word.charAt(r);

            if(set.contains(rightChar - 'a')){                
                frequencies[rightChar - 'a']++;
                if(frequencies[rightChar - 'a'] == 1){      
                    vowels++;
                }
            }
            else{
                consonants++;
            }

            while(consonants > k){
                char leftChar = word.charAt(l);
                if(set.contains(leftChar - 'a')){
                    frequencies[leftChar - 'a']--;
                    if(frequencies[leftChar - 'a'] == 0){
                        vowels--;
                    }
                }
                else{
                    consonants--;
                }
                l++;
                extraLeft = 0 ;
            }

            while(vowels == 5 && consonants == k && l < r && set.contains(word.charAt(l) - 'a') && frequencies[word.charAt(l) - 'a'] > 1){
                extraLeft++ ;
                frequencies[word.charAt(l)- 'a']--;
                l++;
            }

            if(vowels == 5 && consonants == k){
                res += (1 + extraLeft);
            }

            r++;
        }
        return res ;
    }
}
