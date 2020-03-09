# content Negotiation

- In Spring the default format is JSON.

15_Internalization_AccepetHeader_default.PNG

16_Internalization_AccepetHeader_lk.PNG

- **Jackscon** - does the binding of the object to json and json to object.
- If we need to get xml we need to add xml dependency.

```xml
    <!-- Link the XML conversion -->
    <dependency>
        <groupId>com.fasterxml.jackson.dataformat</groupId>
        <artifactId>jackson-dataformat-xml</artifactId>
        <!-- <version>1.18.12</version>-->
        <!-- We don't need to specify the version, the Spring dependency management handles that.-->
    </dependency>
```

***outputs:***

19_ContentNegotiation_xml_yes_get.PNG

20_ContentNegotiation_xml_yes_get_byID.PNG

21_ContentNegotiation_xml_yes_POST.PNG