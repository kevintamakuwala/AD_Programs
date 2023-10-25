import 'package:http/http.dart';
import 'dart:convert';

class Todo {
  String id = "", title = "";
  bool completed = false;

  Todo({required this.id});

  Future<void> getApiData() async {
    try {
      var uri = Uri.https('jsonplaceholder.typicode.com', '/todos/${id}');
      Response response = await get(uri);
      Map todo = jsonDecode(response.body);
      title = todo['title'];
      completed = todo['completed'];
    } catch (e) {
      print("Error+${e}");
      title = "Something went wrong";
    }
  }
}
