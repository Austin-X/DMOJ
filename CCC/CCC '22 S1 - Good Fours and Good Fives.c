#include <stdio.h>
#include <stdlib.h>

int main()
{
   int n, ans = 0;
   scanf("%d", &n);
   int mx = n / 4;
   for (int i = 0; i <= mx; i ++) if ((n - i * 4) % 5 == 0) ans ++;
   printf("%d", ans);

   return 0;
}
