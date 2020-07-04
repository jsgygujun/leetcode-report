# 00125 验证回文串

## 题目

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

**说明：**本题中，我们将空字符串定义为有效的回文串。

**示例 1:**

```
输入: "A man, a plan, a canal: Panama"
输出: true
```

**示例 2:**

```
输入: "race a car"
输出: false
```

## 思路

双指针，一个从前到后，一个从后到前，跳过非法字符，一一对比。

## 解法

```java
public boolean isPalindrome(String s) {
  if (s == null || s.isEmpty()) return true;
  for (int i = 0, j = s.length()-1; i < j; ++i, --j) {
    while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) ++i;
    while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) --j;
    if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
  }
  return true;
}
```



