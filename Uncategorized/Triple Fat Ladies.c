#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
   int cubes[100];
   char str[20];
   int idx = 0;
   for (int i = 1; i <= 21000; i ++) {
      long long x = (long long) i * i * i, flag = 1;
      sprintf(str, "%lld", x);
      if (strlen(str) < 3 || strlen(str) >= 3 && strcmp(&str[strlen(str) - 3], "888") != 0) flag = 0;
      if (flag) cubes[idx++] = i;
   }
  
   int t, k;
   scanf("%d", &t);
   while (t-- > 0) { 
      scanf("%d", &k);
      for (int i = 0; i < idx; i ++) if (cubes[i] > k) { printf("%d\n", cubes[i]); break; }
   }

   return 0;
}
