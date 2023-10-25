import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Home(),
  ));
}

class Home extends StatefulWidget {
  Home({super.key});

  @override
  State<Home> createState() {
    return _HomeState();
  }
}

class _HomeState extends State<Home> {
  @override
  Widget build(BuildContext b) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Apple"),
        centerTitle: true,
      ),
    );
  }
}
