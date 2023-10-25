import 'package:flutter/material.dart';
import 'package:http/http.dart';
import 'dart:convert';
import 'todo.dart';

//  onRequest
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
  String title = "loading";
  String completed = "loading";

  void setTodo() async {
    Todo todo = Todo(id: '-100');
    await todo.getApiData();
    setState(() {
      title = todo.title;
      completed = todo.completed.toString();
    });
    print(title);
    print(completed);
  }

  @override
  void initState() {
    super.initState();
    setTodo();
  }

  @override
  Widget build(BuildContext b) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Apple"),
        centerTitle: true,
      ),
      body: Column(
        children: [
          Text(title),
          Text(completed),
        ],
      ),
    );
  }
}
