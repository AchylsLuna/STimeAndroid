package api

class routes { }
{
        Route::post('/login', [AuthController::class, 'login']);
        Route::post('/signup', [AuthController::class, 'register']);

    }
}