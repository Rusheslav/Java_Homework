package HW_2;

/**
Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

 public class Ex001 {
    public static void main(String[] args) {
        StringBuilder sqlRequest = new StringBuilder("SELECT * FROM students WHERE ");
        String data = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String clearData = data.replace("{", "").replace("}", "").replace("\"", "");
        String[] arrData = clearData.split(", ");
        StringBuilder whereRequest = new StringBuilder("");
        for (int i = 0; i < arrData.length; i++) {
            String[]dataSet = arrData[i].split(":");
            if (!dataSet[1].equals("null")) {
                if (!whereRequest.toString().equals("")) {
                    whereRequest.append(" AND ");
                }
                whereRequest.append(dataSet[0]).append(" = '").
                append(dataSet[1]).append("'");
                // whereRequest.append(String.format("%1$s = '%2$s'", dataSet[0], dataSet[1]));
            }
        }
        sqlRequest.append(whereRequest).append(";");
        System.out.println(sqlRequest);
    }
}
