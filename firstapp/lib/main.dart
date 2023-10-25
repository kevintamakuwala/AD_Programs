import 'package:flutter/material.dart';

// void main(){
//   runApp(MaterialApp(
//     home:Scaffold(
//       appBar:AppBar(
//         title:const Text("Zomato"),
//         centerTitle: true,
//       ),
//       body:const Center(
//           child:const Text("Hello User"),
//     ),
//         floatingActionButton:FloatingActionButton(
//           onPressed: (){
//             child:const Text("daba diya");
//           },
//           child: const Center(
//             child:Text("daba de"),
//           )
//         ),
//     )
//   ));
// }

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
          appBar: AppBar(
            title: const Center(
              child: const Text("XOXO"),
            ),
          ),
          body: const Center(
            child:const Text("Kem Cho lala!")
          ),
          floatingActionButton: FloatingActionButton(
            onPressed: (){},
            child: const Text("daba de idhar "),
          ),
      ),


    ),
  );
}
