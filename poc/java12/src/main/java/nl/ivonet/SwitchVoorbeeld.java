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

package nl.ivonet;

/**
 * @author Ivo Woltring
 */
public class SwitchVoorbeeld {

    public String klasiekeSwitch(int dag) {
        final String waarde;
        switch (dag) {
            case 1:     // geen break gebruikt dus valt hij door naar de volgende case als niet true
            case 2:
            case 3:
            case 4:
            case 5:
                waarde = "weekdag";
                break;
            case 6:
            case 7:
                waarde = "weekend";
                break;
            default:
                waarde = "onbekend";
        }
        return waarde;
    }

    public String dag(int day) {
        return switch (day) {
            case 1,2, 3, 4, 5  ->"weekdag";
            case 6,7 ->"weekend";
            default ->"invalid";
        } ;
    }

    public boolean isWeekend(String day) {
        return switch (day) {
            case "maandag","dinsdag", "woensdag", "donderdag", "vrijdag" -> false;
            case "zaterdag","zondag" -> true;
            default ->{
                if (day.startsWith("z")) {
                    System.out.println("Lijkt op weekend");
                    break true;
                }

                System.out.printf("Onbekende dag: %s%n", day);
                break false;
            }
        } ;
    }
}
