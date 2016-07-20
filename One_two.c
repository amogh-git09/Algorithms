#include<stdio.h>

void reverse(char* str){
  int n = 0;
  int i = 0;
  while(str[i] != '\0'){
    n++;
    i++;
  }

  int l = 0;
  int r = n-1;
  while(l < r){
    char tmp = str[l];
    str[l] = str[r];
    str[r] = tmp;
    l++;
    r--;
  }
}

int main(int argc, char *argv[]){
  reverse(argv[1]);
  printf("%s\n", argv[1]);
  return 0;
}
