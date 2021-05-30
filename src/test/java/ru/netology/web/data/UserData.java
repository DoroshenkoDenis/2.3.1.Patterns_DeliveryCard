package ru.netology.web.data;

import lombok.*;

@RequiredArgsConstructor
@Value
public class UserData {
    String city;
    String fullName;
    String phoneNumber;

}
