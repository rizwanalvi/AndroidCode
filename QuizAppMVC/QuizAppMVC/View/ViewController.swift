//
//  ViewController.swift
//  QuizAppMVC
//
//  Created by Admin on 20/02/2021.
//  Copyright © 2021 Admin. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    let allQuestion = QuestionBank()
    
    var pickedAnswer : Bool = false
    var questionNumber : Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let firstQuestion = allQuestion.list[questionNumber].questionText
        myQuestion.text = firstQuestion
        
        
        
    }

    @IBOutlet weak var myQuestion: UILabel!
    
    @IBOutlet weak var Score: UILabel!
    @IBOutlet weak var QuestionNumber: UILabel!
    
    
    @IBAction func TrueFalse(_ sender: UIButton) {
        
        if(sender.tag == 1)
        {
            pickedAnswer = true
            //print(pickedAnswer)
        }
        else if(sender.tag == 2){
            pickedAnswer = false
            //print(pickedAnswer)
        }
        
        
        checkAnswer()
        
        questionNumber = questionNumber + 1
        
        nextQuestion()
        
    }
    
    func checkAnswer()
    {
        let correctAnswer = allQuestion.list[questionNumber].answer
        
        if(pickedAnswer == correctAnswer)
        {
            print("Wah Kya baat hai!! ap Mental hi hain")
        }
        else{
            print("Mubarak ap phir bhi Metal hi hain")
        }
        
    }
    
    func nextQuestion()
    {
        if questionNumber <= 3
        {
        myQuestion.text = allQuestion.list[questionNumber].questionText
        }
        else{
            print("Quiz Over")
            questionNumber = 0
            myQuestion.text = allQuestion.list[questionNumber].questionText
        }
    }
    
    
    
}

