#include <iostream>
#include <cstdlib>
using namespace std;
bool ok(int a[], int n){
   for(int i = 0; i < n; i++){
      if((a[i] == a[n])||(abs(a[n]-a[i])==(n-i)))return false;
   }
   return true;
}
int nqueens(int n){
     int *a = new int[n];
     int c =0, count =0;
     a[0] =0;
     while(true){
        c++;
        if(c == n){ 
           count++;
           c--;
           if(c==-1){ 
               delete []a;
               return count;
           }    
        }   
        else a[c] = -1;
        while(a[c]!= n){
           a[c]++;
           if(a[c] == n){
              c--;   
              if(c==-1){ 
                  delete []a;
                  return count;
              }
           }
           else if(ok(a,c)) break;
        }               
    }
}
int main(){
    for(int i = 1; i <= 9; i++)
      cout<<i<<" "<<nqueens(i)<<endl;
    return 0;
}
