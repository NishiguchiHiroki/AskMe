
初期設定：
INSERT INTO public.users(
	id, username, email, address, profession, background, introduction, password, enabled, authority, createtime, update)
	VALUES (1, 'testuser', 'testuser@gmail.com', '大阪', 'エンジニア', '大阪大学', '初めてのユーザ', '22465b478b7409aca964716102421474469e6c22d633078b3321f1c196d498922057452920b00707', 1, 'ADMIN', '20220920', '20220920'
	);

INSERT INTO public.share(
	id, share_flag, question_id, user_id, createtime, update)
	VALUES (1, 0, 1, 1, '2022-09-20', '2022-09-20');
	
INSERT INTO public.respondent(
	ans_id, question_id, respondent, delete_flag, createtime, update)
	VALUES (1, 1, 'テストユーザ', 0, '2022-09-20', '2022-09-20');
	
INSERT INTO public.question_like(
	id, question_id, user_id, like_flag, createtime, update)
	VALUES (1, 1, 1, 0, '2022-09-20', '2022-09-20');
	
INSERT INTO public.question_genre(
	genre_id, question_id, createtime, update)
	VALUES (1, 1, '2022-09-20', '2022-09-20');

INSERT INTO public.question(
	id, title, ques_content, image, user_id, delete_flag, createtime, update)
	VALUES (1, 'テストタイトル', 'テストコンテンツ', null, 1, 0, '2022-09-20', '2022-09-20');

INSERT INTO public.notification(
	notification_flag, user_id, answer_id, question_like_id, comment_id, comment_like_id, follow_id, keep_id, share_id, message_id, createtime, update)
	VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2022-09-20', '2022-09-20');
	
INSERT INTO public.message(
	id, message_content, sender_id, reception_id, createtime, update)
	VALUES (1, 'テストメッセージ', '1', '2', '2022-09-20', '2022-09-20');
	
INSERT INTO public.keep(
	id, question_id, user_id, createtime, update)
	VALUES (1, 1, 1, '2022-09-20', '2022-09-20');

INSERT INTO public.genre(
	id, genrename, creater, enabled, createtime, update)
	VALUES (1, 'テストジャンル', 1, 0, '2022-09-20', '2022-09-20');
	
INSERT INTO public.follow(
	id, follow_flag, follow_id, follower_id, createtime, update)
	VALUES (1, 1, 1, 2, '2022-09-20', '2022-09-20');
	
INSERT INTO public.comment_like(
	id, comment_id, user_id, like_flag, createtime, update)
	VALUES (1, 1, 1, 0, '2022-09-20', '2022-09-20');
	
INSERT INTO public.comment(
	id, comment_content, question_id, user_id, delete_flag, createtime, update)
	VALUES (1, 'テストコンテンツ', 1, 1, 0, '2022-09-20', '2022-09-20');
	
INSERT INTO public.answer(
	id, ans_content, image, question_id, delete_flag, createtime, update)
	VALUES (1, 'テストコンテンツ', null, 1, 0, '2022-09-20', '2022-09-20');







