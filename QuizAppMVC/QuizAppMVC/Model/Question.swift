//
//  File.swift
//  QuizAppMVC
//
//  Created by Admin on 20/02/2021.
//  Copyright © 2021 Admin. All rights reserved.
//

import Foundation

class Question
{
    let questionText : String
    let answer : Bool
    
    init(text: String, correctAnswer: Bool) {
        questionText = text
        answer = correctAnswer
    }
    
}
