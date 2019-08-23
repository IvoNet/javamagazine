/*
 * Copyright 2019 Ivo Woltring <WebMaster@ivonet.nl>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class MultiLineStrings {
    public static void main(String[] args) {
        String niet = "<html>\n" +
                      "    <body>\n" +
                      "        <p>Hello, world</p>\n" +
                      "    </body>\n" +
                      "</html>\n";

        String maar = """
                      <html>
                          <body>
                              <p>Hello, world</p>
                          </body>
                      </html>
                      """;
        System.out.println(maar);

        String query = """
                       SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
                       WHERE `CITY` = 'INDIANAPOLIS'
                       ORDER BY `EMP_ID`, `LAST_NAME`;
                       """;
        System.out.println(query);
    }
}
