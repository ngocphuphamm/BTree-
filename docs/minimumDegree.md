Trong ngữ cảnh của cây B (B-tree), minimum degree (mức độ tối thiểu) không phải là chiều cao của cây mà là một tham số quan trọng xác định số lượng khóa và con tối thiểu cũng như tối đa mà mỗi nút có thể chứa. Hãy cùng làm rõ điều này:

Minimum Degree
𝑡
t
Minimum Degree
𝑡
t: Đây là tham số xác định một số tính chất quan trọng của cây B. Cụ thể:
Mỗi nút (ngoại trừ gốc) phải có ít nhất
𝑡
−
1
t−1 khóa.
Mỗi nút có thể có tối đa
2
𝑡
−
1
2t−1 khóa.
Mỗi nút nội (non-leaf) phải có ít nhất
𝑡
t con.
Mỗi nút có thể có tối đa
2
𝑡
2t con.
Cấu trúc của một nút trong cây B
Keys: Mỗi nút chứa một mảng các khóa được sắp xếp.
Children: Mỗi nút nội chứa một mảng các con trỏ đến các nút con.
Number of keys: Số lượng khóa hiện tại trong nút.
Leaf: Một cờ (flag) chỉ ra nút này là lá (không có con) hay không.
Ví dụ về cây B với
𝑡
=
3
t=3
Giả sử cây B có minimum degree
𝑡
=
3
t=3:

Một nút có thể chứa tối thiểu
𝑡
−
1
=
2
t−1=2 khóa.
Một nút có thể chứa tối đa
2
𝑡
−
1
=
5
2t−1=5 khóa.
Một nút nội có thể có tối thiểu
𝑡
=
3
t=3 con.
Một nút có thể có tối đa
2
𝑡
=
6
2t=6 con.

Ví dụ minh họa

```
Minimum degree t = 3

         [10, 20]
        /   |    \
      /     |     \
   [5, 6] [12, 15] [22, 30, 35]
```

Nút gốc chứa 2 khóa (nằm trong khoảng
𝑡
−
1
t−1 và
2
𝑡
−
1
2t−1).

Nút gốc có 3 con (nằm trong khoảng
𝑡
t và
2
𝑡
2t).


Các nút con có 2 hoặc 3 khóa, nằm trong giới hạn được xác định bởi
𝑡
t.


Tóm lại
Minimum degree
𝑡
t của cây B không phải là chiều cao của cây mà là một tham số quan trọng xác định số lượng khóa và con mà mỗi nút có thể chứa. Nó ảnh hưởng đến cách tổ chức và cân bằng của cây B, giúp đảm bảo rằng cây luôn cân bằng và hiệu quả trong các thao tác.