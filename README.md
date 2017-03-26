#Woxi: A cognitive voicemail assistant that creates smart reminders. 
## Inspiration
When was the last time you checked your voicemail? It’s been awhile huh? Well, you are not alone. A recent survey by eVoice, a provider of virtual phone services, found that only 33 percent of people listen to voice mail from business contacts. Only 18 percent listen to voicemails from numbers they don't know. 

Yet, sometimes voicemails can be very important. For diabetics, it is crucial for them to be informed when their insulin prescriptions are refilled and ready for pickup. People are so busy now a days that they often miss the calls and unknowingly ignore their voicemails from their doctors, dentists, and pharmacies. Woxi allows our users to rest assured as their voicemails are no longer neglected. 

## What it does

Woxi is smart voicemail assistant that scrupulously analyzes voicemails to create smart reminders and calendar events. If your doctor’s office leaves you a voicemail asking you to schedule a follow up appointment, Woxi automatically creates a tentative calendar event integrated with smart reminders strategically placed in free time-slots in your busy schedule. The tentative event is confirmed using our seamless Facebook messenger chat bot. Woxi works around you! 

You might be wonder : “Will Woxi make random events when random people leave voice mails?” The answer is NO. Woxi recognizes and doesn’t act on spam voicemails.

## How we built it

Native Android app built with android studio. Version control with GitHub.

We used IBM Watson’s Speech-to-Text for converting the voicemail speech into data that we can analyze.

We analyzed the data using 

We used Google Calendar API to create Woxi’s smart reminder skill. 

Facebook messenger Chatbot is built with Facebook Graph API, Heroku, and Node.js.


## What's next for Woxi

Woxi is currently tackling a small part, voicemail optimization, of a potentially huge cognitive smartphone assistant app used to automate tasks. In the short term, we want to expand our keyword algorithm to incorporate business scenarios. Woxi as an artificially intelligent secretary. 

In the future, we plan to utilize Watson's Retrieve and Rank service to improve our keyword algorithm and smart reminder feature using machine learning. Woxi will be able to learn from each voicemail you get and make more detailed and elegant calendar events.

