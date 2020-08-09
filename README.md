# Data quality in social networks 
>fast unsupervised spam detection approach for trending topics

-----

## Table of contents

- [Description](#Description)
- [Methodology](#Metodology)
- [Technologies](#Technologies)


------

##Description

In this work, we design an automated unsupervised method that 
takes the collective perspective of users with their tweets to
filter out the spam tweets in large-scale of trending topics. 
Our approach leverages the simple meta-data (e.g. user name, 
tweet content) that available in tweet object in performing 
the classification, with keeping away from performing timely 
constrained API calls. Our method is experimented on filtering 
more than 6 million tweets posted in 50 trending topics in few days.

##Methodology
First, we collect a set of tweets, then we extract the users for a particular hashtag.
Secondly, we perform clustering based on age attribute of users. In the third stage
and for each age cluster, we detect the communities that the users are belonging to 
through leveraging the user name, screen name and naming writing style(between user name
and screen name). Performing clustering and community detection might be viewed as
preprocessing steps to cluster and group the users that have common features
(matched names, writing style tweets similarity, duplicated tweets, and posting tweets
behavior similarity) as a fourth stage. At last, to make a decision about the type
(spammy or non-spammy) of those communities, we compare the values of the extracted
features one after another based on their importance with a certain threshold.

##Technologies
 Java












