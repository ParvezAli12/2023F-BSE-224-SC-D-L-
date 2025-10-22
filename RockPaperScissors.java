import random
import time

def print_delay(message, delay=1):
    print(message)
    time.sleep(delay)

def get_user_choice():
    choices = ['rock', 'paper', 'scissors']
    while True:
        user_input = input("Choose Rock, Paper, or Scissors: ").strip().lower()
        if user_input in choices:
            return user_input
        else:
            print("Invalid choice. Please try again.")

def get_computer_choice():
    choices = ['rock', 'paper', 'scissors']
    return random.choice(choices)

def decide_winner(user, computer):
    if user == computer:
        return 'tie'
    elif (user == 'rock' and computer == 'scissors') or \
         (user == 'paper' and computer == 'rock') or \
         (user == 'scissors' and computer == 'paper'):
        return 'user'
    else:
        return 'computer'

def commentary(winner, user_choice, computer_choice):
    if winner == 'tie':
        print(f"Both chose {user_choice.capitalize()}. It's a tie!")
    elif winner == 'user':
        print(f"{user_choice.capitalize()} beats {computer_choice.capitalize()}. You win this round!")
    else:
        print(f"{computer_choice.capitalize()} beats {user_choice.capitalize()}. Computer wins this round!")

def play_game():
    print("Welcome to Rock, Paper, Scissors!")
    print("We will play best of 5 rounds. May the best player win!\n")
    
    user_score = 0
    computer_score = 0
    rounds_played = 0
    rounds_to_win = 3  # Best of 5 means first to 3 wins

    while user_score < rounds_to_win and computer_score < rounds_to_win:
        print(f"\n--- Round {rounds_played + 1} ---")
        user_choice = get_user_choice()
        computer_choice = get_computer_choice()

        print_delay("Rock...")
        print_delay("Paper...")
        print_delay("Scissors!")
        
        winner = decide_winner(user_choice, computer_choice)
        commentary(winner, user_choice, computer_choice)

        if winner == 'user':
            user_score += 1
        elif winner == 'computer':
            computer_score += 1
        
        rounds_played += 1
        print(f"Score -> You: {user_score} | Computer: {computer_score}")

    print("\nGame Over!")
    if user_score > computer_score:
        print("🎉 Congratulations! You won the game!")
    else:
        print("Computer wins the game! Better luck next time!")

    play_again = input("\nDo you want to play again? (yes/no): ").strip().lower()
    if play_again.startswith('y'):
        print("\nStarting a new game...\n")
        play_game()
    else:
        print("Thanks for playing! Goodbye!")

if __name__ == "__main__":
    play_game()
