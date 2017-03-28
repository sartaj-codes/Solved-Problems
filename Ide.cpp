#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;
struct knap{
    float val;
    float wt;
    float perunit;
};
bool sortByP(const knap &lhs, const knap &rhs) { return lhs.perunit > rhs.perunit; }

int main() {
  
 vector<knap> arr(3);
 
 for(vector<knap>::size_type i = 0; i < 3 ; i++)
 {
     cin>>arr[i].val;
     
     cin>>arr[i].wt;
     
     arr[i].perunit = (arr[i].val/arr[i].wt);
 }
   int capcity;
   cin>>capcity;
   sort(arr.begin(), arr.end(), sortByP);
    
   float ans = 0;    
   for(int i = 0; i<3 && capcity!= 0 ; i++)
   {
       if(capcity >= arr[i].wt)
       {
           ans     += arr[i].val;
           capcity -= arr[i].wt;
       }
       else
         {
             ans += (arr[i].val/(arr[i].wt/capcity));
             capcity = 0; 
         }    
   }
   cout<<"Pi"<<" "<<"mi"<<" "<<"Pi/mi"<<endl;
   for(int i = 0; i < 3; i++)
   {
       cout<<arr[i].val<<" ";
       cout<<arr[i].wt<<" ";
       cout<<arr[i].perunit<<endl;
   }
    cout<<"Optimised knapsack 0-1: "<<ans<<endl;
	return 0;
}
