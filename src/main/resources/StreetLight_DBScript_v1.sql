��C R E A T E   T A B L E   t b l B a t t e r y (  
 	 B a t t e r y I D   i n t   N U L L ,  
 	 Z o n e I D   i n t   N U L L ,  
 	 C a p a c i t y   i n t   N U L L ,  
 	 V o l t a g e   i n t   N U L L ,  
 	 C h a r g e M o d e   t e x t   N U L L ,  
 	 C u r r e n t L e v e l O f C h a r g e   i n t   N U L L  
 )    
  
  
 C R E A T E   T A B L E   t b l C i t i e s (  
 	 C i t y I D   i n t   N U L L ,  
 	 C i t y N a m e   t e x t   N U L L ,  
 	 S t a t u s   b o o l e a n   N U L L  
 )  
  
 C R E A T E   T A B L E   t b l P o l e H e a l t h D e s c (  
 	 H e a l t h I D   i n t   N U L L ,  
 	 H e a l t h D e s c   t e x t   N U L L  
 )  
  
 C R E A T E   T A B L E   t b l P o l e s (  
 	 P o l e I D   i n t   N U L L ,  
 	 Z o n e I D   i n t   N U L L ,  
 	 P o w e r I n p u t I n V o l t s   i n t   N U L L ,  
 	 H e a l t h S t a t u s   i n t   N U L L ,  
 	 S w i t c h   b o o l e a n   N U L L  
 )  
    
 C R E A T E   T A B L E   t b l R u n n i n g P o l e s (  
 	 P o l e I D   i n t   N U L L ,  
 	 L i g h t S t a r t T i m e   t i m e s t a m p   N U L L ,  
 	 L i g h t E n d T i m e   t i m e s t a m p   N U L L ,  
 	 L i g h t I l l u m i n a t i o n   i n t   N U L L ,  
 	 L i g h t O u t p u t I n L u x   i n t   N U L L ,  
 	 P o w e r C o n s u m p t i o n I n W a t t s   i n t   N U L L ,  
 	 H e a l t h S t a t u s   i n t   N U L L  
 )  
  
 C R E A T E   T A B L E   t b l Z o n e L u m e n (  
 	 L u m e n I D   i n t   N U L L ,  
 	 Z o n e I D   i n t   N U L L ,  
 	 L u m e n V a l u e   i n t   N U L L ,  
 	 S t a r t T i m e   t i m e s t a m p   N U L L ,  
 	 E n d T i m e   t i m e s t a m p   N U L L  
 )    
  
 C R E A T E   T A B L E   t b l Z o n e s (  
 	 Z o n e I D   i n t   N U L L ,  
 	 Z o n e N a m e   t e x t   N U L L ,  
 	 C i t y I D   i n t   N U L L ,  
 	 M i n P o l e C o u n t   i n t   N U L L ,  
 	 M a x P o l e C o u n t   i n t   N U L L  
 )  
  
 I N S E R T   i n t o   t b l B a t t e r y   ( B a t t e r y I D ,   Z o n e I D ,   C a p a c i t y ,   V o l t a g e ,   C h a r g e M o d e ,   C u r r e n t L e v e l O f C h a r g e )   V A L U E S    
 ( 1 ,   1 ,   5 0 0 0 ,   1 2 ,   ' S o l a r ' ,   5 0 0 0 ) ,  
 ( 2 ,   2 ,   5 0 0 0 ,   1 2 ,   ' S o l a r ' ,   4 5 0 0 ) ,  
 ( 3 ,   3 ,   5 0 0 0 ,   1 2 ,   ' E B ' ,   5 0 0 0 ) ,  
 ( 4 ,   4 ,   5 0 0 0 ,   1 2 ,   ' S o l a r ' ,   3 0 0 0 )  
  
  
 I N S E R T   i n t o   t b l C i t i e s   ( C i t y I D ,   C i t y N a m e ,   S t a t u s )   V A L U E S    
 ( 1 ,   ' H y d e r a b a d ' ,   t r u e ) ,  
 ( 2 ,   ' V i j a y a w a d a ' ,   t r u e ) ,  
 ( 3 ,   ' V i s a k a p a t n a m ' ,   t r u e )  
  
  
 I N S E R T   t b l P o l e H e a l t h D e s c   ( H e a l t h I D ,   H e a l t h D e s c )   V A L U E S  
 ( 1 ,   ' G o o d ' ) ,  
 ( 2 ,   ' B a d ' ) ,  
 ( 3 ,   ' N e e d s   M a i n t e n a n c e ' )  
  
  
 I N S E R T   i n t o   t b l P o l e s ( P o l e I D , Z o n e I D , P o w e r I n p u t I n V o l t s , H e a l t h S t a t u s , S w i t c h )   V A L U E S    
 ( 1 ,   1 ,   1 2 ,   1 ,   t r u e ) ,  
 ( 2 ,   1 ,   1 2 ,   1 ,   t r u e ) ,  
 ( 3 ,   1 ,   1 2 ,   2 ,   f a l s e ) ,  
 ( 4 ,   2 ,   1 2 ,   3 ,   f a l s e ) ,  
 ( 5 ,   2 ,   1 2 ,   1 ,   t r u e ) ,  
 ( 6 ,   2 ,   1 2 ,   2 ,   f a l s e ) ,  
 ( 7 ,   2 ,   1 2 ,   3 ,   f a l s e ) ,  
 ( 8 ,   3 ,   1 2 ,   1 ,   t r u e ) ,  
 ( 9 ,   3 ,   1 2 ,   1 ,   t r u e ) ,  
 ( 1 0 ,   4 ,   1 2 ,   1 ,   t r u e )  
  
  
 I N S E R T   i n t o   t b l Z o n e s   ( Z o n e I D ,   Z o n e N a m e ,   C i t y I D ,   M i n P o l e C o u n t ,   M a x P o l e C o u n t )   V A L U E S    
 ( 1 ,   ' H i t e c h C i t y ' ,   1 ,   2 0 ,   1 0 0 ) ,  
 ( 2 ,   ' S u r a r a m ' ,   1 ,   2 0 ,   1 0 0 ) ,  
 ( 3 ,   ' K P H B ' ,   1 ,   2 0 ,   1 0 0 ) ,  
 ( 4 ,   ' M o t h i n a g a r ' ,   1 ,   2 0 ,   1 0 0 )  
  
  
 I N S E R T   i n t o   t b l Z o n e L u m e n   ( L u m e n I D ,   Z o n e I D ,   L u m e n V a l u e ,   S t a r t T i m e ,   E n d T i m e )   V A L U E S  
 ( 1 ,   1 ,   5 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   0 3 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   0 5 : 0 0 : 0 0 . 0 0 0 ' )  
 , ( 2 ,   1 ,   1 6 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   0 5 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   0 7 : 0 0 : 0 0 . 0 0 0 ' )  
 , ( 3 ,   1 ,   4 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   0 7 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   0 9 : 0 0 : 0 0 . 0 0 0 ' )  
 , ( 4 ,   1 ,   1 0 0 0 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   0 9 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   1 1 : 0 0 : 0 0 . 0 0 0 ' )  
 , ( 5 ,   1 ,   1 0 0 0 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   1 1 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   1 3 : 0 0 : 0 0 . 0 0 0 ' )  
 , ( 6 ,   1 ,   1 2 0 0 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   1 3 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   1 5 : 0 0 : 0 0 . 0 0 0 ' )  
 , ( 7 ,   1 ,   1 0 0 0 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   1 5 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   1 6 : 0 0 : 0 0 . 0 0 0 ' )  
 , ( 8 ,   1 ,   4 5 0 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   1 6 : 0 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   1 6 : 3 0 : 0 0 . 0 0 0 ' )  
 , ( 9 ,   1 ,   1 5 0 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   1 6 : 3 0 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   1 6 : 5 5 : 0 0 . 0 0 0 ' )  
 , ( 1 0 ,   1 ,   4 0 0 0 ,   ' 2 0 1 6 - 0 9 - 1 2   1 6 : 5 5 : 0 0 . 0 0 0 ' , ' 2 0 1 6 - 0 9 - 1 2   1 7 : 2 5 : 0 0 . 0 0 0 ' ) 