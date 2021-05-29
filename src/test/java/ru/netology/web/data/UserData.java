package ru.netology.web.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class UserData {
    private final String city;
    private final String fullName;
    private final String phoneNumber;
}
