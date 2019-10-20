#include <iostream>
#include <cmath>
using namespace std;
bool ok(int a[], int n){
    for(int i = 0; i < n; i++){
        if((a[i] == a[n])||(abs(a[n]-a[i])==(n-i)))return false;
    }
    return true;
}
int main(){
    int q[8] = {0}, c = 0, count = 0;     
    while(true){
        c++;
        q[c]= -1;
        if(c==8){
            count++;
            cout <<"Solution # " <<count <<endl;  
            for(int i = 0; i < 8; i++){
               for(int j = 0; j < 8; j++){
                   if(q[i] == j) cout <<"X";
                   else cout <<"0";
               }
               cout <<endl; 
            }
            c--;
            if(c == -1) return 0;
        }
        while(q[c]!=8){
          q[c]++;
          if(q[c] == 8){ 
              c--; 
              if(c == -1) return 0;
              continue;
          }
          if(ok(q,c))break;
          else continue;   
        }
    }     
}
