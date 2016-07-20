#include<stdio.h>
#include<string.h>

void replace(char *str, int n){
  int i, spaces=0;
  for(i = 0; i<n; i++){
    printf("i: %d, n: %d\n", i, n);
    if(str[i] == ' '){
      spaces++;
      int j;
      for(j = n; j >= i; j--){
        printf("i: %d, n: %d, j: %d\n", i, n, j);
        str[j+2] = str[j];
      }
      str[i] = '%';
      str[i+1] = '2';
      str[i+2] = '0';
      i += 2;
    }
  }

  str[n+2*spaces] = '\0';
}

int main(){
  char *str = "a  rat ";
  replace(str, strlen(str));
  printf("%s", str);

  return 0;
}
