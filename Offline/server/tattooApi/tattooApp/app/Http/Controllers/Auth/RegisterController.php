<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class RegisterController extends Controller
{
    public function register(Request $request)
    {

        $this->validate($request, [
            'name' => 'required|min:1|unique:users',
            'email' => 'required|email|unique:users',
            'password' => 'required|min:1',
        ]);

        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => bcrypt($request->password)
        ]);

        $token = $user->createToken('authToken')->accessToken;

        return response()->json(['token' => $token], 200);
    }

    public function getUsers()
    {
        $users= DB::table('users')
            ->select('*')
            ->get();

        return response()->json(['users' => $users], 200);
    }

}
