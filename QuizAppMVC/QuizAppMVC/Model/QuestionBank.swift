//
//  QuestionBank.swift
//  QuizAppMVC
//
//  Created by Admin on 20/02/2021.
//  Copyright © 2021 Admin. All rights reserved.
//

import Foundation

class QuestionBank {
    
    var list = [Question]()
    
    init() {
        
        let item = Question(text: "Are you Mental?", correctAnswer: true)
        list.append(item)
        
        list.append(Question(text: "Are you Pagal?", correctAnswer: true))
        
        list.append(Question(text: "Are you Chariya?", correctAnswer: true))
        
        list.append(Question(text: "Are you aqalmand?", correctAnswer: false))
        
    }
    
    
    
}
