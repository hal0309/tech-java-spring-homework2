# homework2

> [!IMPORTANT]  
> 毎回branchを作成して作業を行い、次週までにmasterにpull requestを送ってください。




## 1月7日 課題

---

### 1. 現状確認

既に記述されているソースコードを確認し、postmanを用いて
`{{LOCALHOST}}/wine/getWineListSortByPoints`にgetリクエストを送ると、
評価が高い順にソートされたワインのリストが返ってくる事を確認してください。

~~~
[
    {
        "country": "Italy",
        "points": "88",
        "price": "19.0",
        "province": "Tuscany",
        "pointsInt": 88
    },
    {
        "country": "US",
        "points": "88",
        "price": "23.0",
        "province": "California",
        "pointsInt": 88
    },
    ...(省略)
]
~~~

### 2. フィルタリング
新しいエンドポイント`getWineListUS`、`getWineListItary`を作成し、呼び出した際に、
それぞれアメリカ産、イタリア産のワインのみを返すようにしてください。

### 3. ソート
新しいエンドポイント`getWineListSortByPrice`を作成し、呼び出した際に、
価格が高い順にソートされたワインのリストが返ってくるようにしてください。

> [!INFORMATION]  
> プロパティ`price`は`String`型です。そのため、ソートする際には、`double`型に変換する必要があります。  
> `Wine`クラスに既に`points`を`int`型に変換・取得するメソッドが定義されているので、参考にしてみてください。  
> また、方法によっては、加えて`double`型でソートしようとするとエラーになります。なんとかしてください :)

## 12月16日 課題

---
### 1. 現状確認

既に記述されているソースコードを確認し、
postmanを用いて`{{LOCALHOST}}/wine/getRawCsv`にgetリクエストを送ると、
レスポンスが以下になる事を確認してください。

~~~
[
    "0,Italy,\"Aromas include tropical fruit, broom, brimstone and dried herb. The palate isn't overly expressive, offering unripened apple, citrus and dried sage alongside brisk acidity.\",Vulkà Bianco,87,,Sicily & Sardinia,Etna,,Kerin O’Keefe,@kerinokeefe,Nicosia 2013 Vulkà Bianco  (Etna),White Blend,Nicosia",
    "1,Portugal,\"This is ripe and fruity, a wine that is smooth while still structured. Firm tannins are filled out with juicy red berry fruits and freshened with acidity. It's  already drinkable, although it will certainly be better from 2016.\",Avidagos,87,15.0,Douro,,,Roger Voss,@vossroger,Quinta dos Avidagos 2011 Avidagos Red (Douro),Portuguese Red,Quinta dos Avidagos",
    ...(省略)
]
~~~

### 2. Wineクラスの定義

今のままだと、ワインのデータが文字列になっていて扱いづらい。そのため、`Wine`クラスを定義し、ワインのデータをオブジェクトとして扱えるようにしてください。

尚、`Wine`クラスのプロパティは、上記のラベルを参考に、`country`, `points`, `price`, `province`の4つとし、全て`String`型としてください。(余裕があれば適切な型に変換してください。)

> [!NOTE]  
> ディレクトリ構成(Wineクラスを置く場所)は自分で考えてみてください。

### 3. Wineクラスの変換・取得

csvの各行が文字列として収められている、`rawCsvList`をもとに、`Wine`クラスのリストを作成してください。
また、`Wine`クラスのリストを取得するための`getWineList`メソッドを作成し、getリクエストを受け付けるようにしてください。


## 事前情報

---
今回は、ワインの通販サイトのバックエンドプログラムを作成する想定です。  
ワインのデータがまとめてあるcsvファイルを読み込み、適切に処理してください。

ワインのデータセットはKaggleの[Wine Reviews](https://www.kaggle.com/zynicide/wine-reviews)より引用し、データ数を1000件に制限しています。

ラベルと内容の対応関係を以下を参考にしてください。

|ラベル|     内容      |
|:---:|:-----------:|
|country|      国      |
|description|   ワインの解説    |
|designation|   ブドウ畑の名前   |
|points| 評価点数(1～100) |
|price|   価格(米ドル)   |
|province|    県または州    |
|region_1|     地域名     |
|region_2|   地域名(詳細)   |
|variety|     品種      |
|winery|    ワイナリー    |

