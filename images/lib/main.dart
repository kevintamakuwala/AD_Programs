import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    home: Home(),
  ));
}

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext b) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Apple"),
        centerTitle: true,
      ),
      body:Image.asset('/assets/img.png')
    );
  }
}
