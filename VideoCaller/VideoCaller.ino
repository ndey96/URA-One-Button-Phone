const int  buttonPin = 2;

int counter = 0;
int buttonState = 0;
int lastButtonState = 0;

void setup() {
  pinMode(buttonPin, INPUT);
=  Serial.begin(9600);
}


void loop() {
  buttonState = digitalRead(buttonPin);
  if (buttonState != lastButtonState && buttonState == HIGH) {
    counter++;
    flag = !flag;
    Serial.println(counter);
    if (flag) {
      digitalWrite(ledPin, HIGH);
    } else {
      digitalWrite(ledPin, LOW);
    }
    delay(500);
  }
  lastButtonState = buttonState;
}
