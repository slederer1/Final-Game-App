package lederer;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();

		//TASK 2:  ADD A USER GAME OBJECT OF TYPE D
		Type_D_GameObject user = new Type_D_GameObject(200, 200);
		user.setVelocity(10);
		canvas.addKeyListener(user);
		canvas.addGameObject(user);

		Type_A_GameObject user2 = new Type_A_GameObject(10,400);
		user.setVelocity(10);
		canvas.addKeyListener(user2);
		canvas.addGameObject(user2);

		Type_C_GameObject user3 = new Type_C_GameObject(400,600);
		user.setVelocity(10);
		canvas.addKeyListener(user3);
		canvas.addGameObject(user3);

        Type_B_GameObject user4 = new Type_B_GameObject(500, 300);
        user.setVelocity(10);


        Type_B_Adapter adapterUser4 = new Type_B_Adapter(user4);

        // Add the adapter to the canvas
        canvas.addKeyListener(adapterUser4);
        canvas.addGameObject(adapterUser4);
    }

}
