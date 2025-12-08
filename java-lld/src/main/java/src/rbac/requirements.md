Requirements:

Subscription Group ..: Email, User abse dsubscription
Subscriptio Group have different roles..

Owner: has all privilges.. 
they can contribute ena make changes.. 
dleete resoource..

Not an owner but a contributor.. 

A conitrbuter will have access to all access just to edit... 
they cannot make changes to that..
they can push.. cannot make configuraiton changes.
use those resource..  ( al resources access but no access to AI resources)

AI Developer:: 
all resources+ AI resources as well

Core Entities:

User

SubscriptionGroup

Resource

RoleAssignment

Enums: 
ResourceType : {General, AI}
enum Perm: {READ<, EDIT< PUSH, DELTE< USE_RESOURCE, USE_AI}
enum Role: {Owner, COntiributor, AI_Developer}